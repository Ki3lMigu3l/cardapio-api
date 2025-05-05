import api from "./api";

const FoodService = {
  async getAll() {
    try {
      const response = await api.get("/foods");
      console.log("GET /foods response:", response); // Log para debug
      return response.data;
    } catch (error) {
      console.error("Error fetching foods:", {
        config: error.config,
        response: error.response,
        message: error.message,
      });
      throw new Error(error.response?.data?.message || "Failed to fetch foods");
    }
  },

  async create(foodData) {
    try {
      if (typeof foodData.price === "string") {
        foodData.price = parseFloat(foodData.price);
      }

      const response = await api.post("/foods", foodData);
      console.log("POST /foods response:", response); // Log para debug
      return response.data;
    } catch (error) {
      console.error("Error creating food:", {
        dataSent: foodData,
        errorDetails: error.response?.data,
      });
      throw new Error(error.response?.data?.message || "Failed to create food");
    }
  },

  async update(id, foodData) {
    try {
      // Convert price to number if it's a string
      if (typeof foodData.price === "string") {
        foodData.price = parseFloat(foodData.price);
      }

      const response = await api.put(`/foods/${id}`, foodData);
      console.log(`PUT /foods/${id} response:`, response);
      return response.data;
    } catch (error) {
      console.error(`Error updating food ${id}:`, {
        dataSent: foodData,
        errorDetails: error.response?.data,
      });
      throw new Error(error.response?.data?.message || "Failed to update food");
    }
  },

  async delete(id: number) {
    if (!id || isNaN(id) || id <= 0) {
      console.error(`Invalid ID provided for deletion: ${id}`);
      throw new Error("ID inválido");
    }

    const response = await api.delete(`/foods/${id}`);
    console.log(`DELETE /foods/${id} successful`, {
      status: response.status,
      data: response.data,
    });
  },
};

export default FoodService;
