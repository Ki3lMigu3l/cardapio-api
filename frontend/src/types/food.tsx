export interface Food {
  id: number;
  name: string;
  image: string;
  description: string;
  price: number | any;
}

export interface FoodRequest {
  name: string;
  image: string;
  description: string;
  price: number | string;
}
