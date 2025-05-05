import { useEffect, useState } from "react";
import { Card } from "../../components/card/card";
import FoodService from "../../services/service";

export const Home = () => {
  const [foods, setFoods] = useState<any[]>([]);

  useEffect(() => {
    const loadFoods = async () => {
      try {
        const data = await FoodService.getAll();
        setFoods(data);
      } catch (err) {}
    };
    loadFoods();
  }, []);

  return (
    <div className="relative w-full h-90 lg:h-100 2xl:h-130">
      <img
        src="/banner.jpg"
        className="w-full h-90 lg:h-100 2xl:h-130 object-cover"
      />

      <div className="absolute inset-0 bg-black/50 flex items-center justify-center">
        <div className="text-center pt-20 px-4">
          <h2 className="text-4xl md:text-6xl font-bold text-white mb-4 font-serif">
            Sabores que <span className="text-amber-400">encantam</span>
          </h2>
          <p className="text-xl text-white/90 max-w-2xl mx-auto">
            Experimente nossa seleção premium de lanches feitas com ingredientes
            selecionados
          </p>
        </div>
      </div>
      <div className="pt-10 lg:pt-36 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6 p-4 lg:mx-10 xl:mx-24 2xl:mx-60">
        {foods.map((food) => (
          <Card
            key={food.id}
            id={food.id}
            name={food.name}
            image={food.image}
            description={food.description}
            price={food.price}
          />
        ))}
      </div>
    </div>
  );
};
