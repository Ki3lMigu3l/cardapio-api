import { useEffect, useState } from "react";
import { FiEdit2, FiTrash2, FiPlus, FiX } from "react-icons/fi";
import FoodService from "../../services/service";

const AdminPanel = () => {
  const [foods, setFoods] = useState([]);
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [currentFood, setCurrentFood] = useState(null);
  const [imagePreview, setImagePreview] = useState(null);

  // Estado do formulário
  const [formData, setFormData] = useState({
    name: "",
    description: "",
    price: "",
    image: "",
  });

  useEffect(() => {
    loadFoods();
  }, []);

  const loadFoods = async () => {
    try {
      const data = await FoodService.getAll();
      setFoods(data);
    } catch (err) {}
  };

  // Manipular mudanças no formulário
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  // Abrir modal para adicionar novo produto
  const openAddModal = () => {
    setCurrentFood(null);
    setFormData({
      name: "",
      description: "",
      price: "",
      image: "",
    });
    setIsModalOpen(true);
  };

  // Abrir modal para editar produto
  const openEditModal = (food) => {
    setCurrentFood(food);
    setFormData({
      name: food.name,
      description: food.description,
      price: food.price,
      image: food.image,
    });
    setImagePreview(food.imageUrl || null);
    setIsModalOpen(true);
  };

  // Salvar produto (criar ou atualizar)
  const handleSave = async () => {
    try {
      const { name, description, price, image } = formData;

      // Validação simples
      if (!name || !description || !price || !image) {
        alert(
          "Preencha todos os campos: nome, descrição, preço e imagem (URL)."
        );
        return;
      }

      let savedFood;

      if (currentFood) {
        // Atualizar lanche existente
        savedFood = await FoodService.update(currentFood.id, {
          name,
          description,
          price,
          image,
        });

        setFoods((prevFoods) =>
          prevFoods.map((f) => (f.id === currentFood.id ? savedFood : f))
        );
      } else {
        // Criar novo lanche
        savedFood = await FoodService.create({
          name,
          description,
          price,
          image,
        });

        setFoods((prevFoods) => [...prevFoods, savedFood]);
      }

      setIsModalOpen(false);
      setCurrentFood(null);
      setFormData({ name: "", description: "", price: "", image: "" }); // limpa o form
    } catch (error) {
      console.error("Erro ao salvar:", error);
      alert("Erro ao salvar. Verifique os dados e tente novamente.");
    }
  };

  // Deletar produto
  const handleDelete = async (id) => {
    try {
      await FoodService.delete(id);
      loadFoods();
    } catch (err) {}
  };
  //   const handleDelete = (id) => {
  //     const response = await FoodService.delete(id);
  //   };

  return (
    <div className=" flex flex-col pt-36 p-10">
      {/* Header e botão de adicionar */}
      <div className="flex justify-center gap-4 items-center mb-6">
        <h2 className="text-md md:text-2xl lg:text-2xl font-bold text-gray-800">
          Painel Admin
        </h2>
        <button
          onClick={openAddModal}
          className="flex items-center px-4 py-2 bg-amber-600 text-white rounded-lg hover:bg-amber-700 transition-colors cursor-pointer"
        >
          <FiPlus className="mr-2" />
          Adicionar Lanche
        </button>
      </div>

      {/* Lista de produtos */}
      <div className="pt-10 grid grid-cols-1 md:grid-cols-2 lg:grid-cols-2 2xl:grid-cols-4 gap-6">
        {foods.map((food) => (
          <div
            key={food.id}
            className="bg-white rounded-xl hover:shadow-md transition-shadow duration-500 overflow-hidden border border-gray-100 cursor-pointer"
          >
            <div className="flex">
              {/* Imagem do produto (quadrada) */}
              <div className="w-1/3">
                <img
                  src={food.image}
                  alt={food.name}
                  className="w-full h-full object-cover"
                />
              </div>

              {/* Conteúdo do card */}
              <div className="w-2/3 p-4 flex flex-col">
                <div className="flex-grow">
                  <h3 className="font-bold text-lg mb-1">{food.name}</h3>
                  <p className="text-gray-600 text-sm">{food.description}</p>
                </div>

                {/* Preço e Botões de ação */}
                <div className="flex justify-between space-x-2 mt-2">
                  <div className="p-2 text-center font-bold text-amber-600">
                    R$ {food.price}
                  </div>

                  <div>
                    <button
                      onClick={() => openEditModal(food)}
                      className="p-2 text-amber-600 hover:bg-amber-50 rounded-full cursor-pointer"
                      title="Editar"
                    >
                      <FiEdit2 />
                    </button>
                    <button
                      onClick={() => handleDelete(food.id)}
                      className="p-2 text-amber-600 hover:bg-red-50 rounded-full cursor-pointer"
                      title="Excluir"
                    >
                      <FiTrash2 />
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        ))}
      </div>

      {/* Modal para adicionar/editar produto */}
      {isModalOpen && (
        <div className="fixed inset-0 z-50 flex items-center justify-center p-4">
          {/* Fundo com blur e leve dark overlay */}
          <div
            className="absolute inset-0 backdrop-blur-sm bg-black/30 transition-opacity"
            onClick={() => setIsModalOpen(false)}
          ></div>

          {/* Modal */}
          <div className="relative z-10 w-full max-w-lg bg-white rounded-2xl shadow-xl overflow-hidden transition-all duration-300">
            {/* Cabeçalho */}
            <div className="flex items-center justify-between px-6 py-4 border-b border-gray-200 bg-amber-500 text-white">
              <h3 className="text-xl font-semibold tracking-tight">
                {currentFood ? "Editar Lanche" : "Adicionar Lanche"}
              </h3>
              <button
                onClick={() => setIsModalOpen(false)}
                className="p-2 rounded hover:bg-white/20 transition-colors"
                aria-label="Fechar modal"
              >
                <FiX className="w-6 h-6" />
              </button>
            </div>

            {/* Corpo */}
            <div className="px-6 py-6 bg-white space-y-5">
              {/* Nome */}
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">
                  Nome
                </label>
                <input
                  type="text"
                  name="name"
                  value={formData.name}
                  onChange={handleInputChange}
                  className="w-full px-4 py-2 rounded-lg border border-gray-300 focus:ring-2 focus:ring-amber-500 focus:outline-none shadow-sm transition duration-200"
                  placeholder="Nome do lanche"
                />
              </div>

              {/* Descrição */}
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">
                  Descrição
                </label>
                <textarea
                  name="description"
                  value={formData.description}
                  onChange={handleInputChange}
                  rows="3"
                  className="w-full px-4 py-2 rounded-lg border border-gray-300 focus:ring-2 focus:ring-amber-500 focus:outline-none shadow-sm transition duration-200"
                  placeholder="Descrição do lanche"
                ></textarea>
              </div>

              {/* Preço */}
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">
                  Preço
                </label>
                <input
                  type="text"
                  name="price"
                  value={formData.price}
                  onChange={handleInputChange}
                  className="w-full px-4 py-2 rounded-lg border border-gray-300 focus:ring-2 focus:ring-amber-500 focus:outline-none shadow-sm transition duration-200"
                  placeholder="Preço (ex: 19.90)"
                />
              </div>

              {/* Imagem */}
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-2">
                  Imagem
                </label>
                {formData.image && (
                  <div className="mb-3">
                    <img
                      src={formData.image}
                      alt="Pré-visualização"
                      className="w-40 h-40 object-cover rounded-xl border border-gray-200 shadow-md mx-auto hover:scale-105 transition-transform"
                    />
                    <p className="text-center text-xs text-gray-500 mt-2">
                      Pré-visualização
                    </p>
                  </div>
                )}
                <input
                  type="text"
                  name="image"
                  value={formData.image}
                  onChange={handleInputChange}
                  className="w-full px-4 py-2 rounded-lg border border-gray-300 focus:ring-2 focus:ring-amber-500 focus:outline-none shadow-sm transition duration-200"
                  placeholder="URL da imagem"
                />
              </div>
            </div>

            {/* Ações */}
            <div className="flex justify-end gap-3 px-6 py-4 bg-gray-50 border-t border-gray-200">
              <button
                onClick={() => setIsModalOpen(false)}
                className="px-4 py-2 rounded-lg bg-gray-100 hover:bg-gray-200 text-gray-700 transition"
              >
                Cancelar
              </button>
              <button
                onClick={handleSave}
                className="px-5 py-2 rounded-lg bg-amber-600 hover:bg-amber-700 text-white font-medium shadow-md transition"
              >
                {currentFood ? "Atualizar" : "Salvar"}
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default AdminPanel;
