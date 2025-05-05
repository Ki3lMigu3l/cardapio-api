interface CardProps {
  id: string | number;
  name: string | any;
  image: string | any;
  description: string | any;
  price: number;
}

export const Card = ({ name, image, description, price }: CardProps) => {
  return (
    <div className="bg-white rounded-lg shadow-sm overflow-hidden hover:shadow-lg transition-shadow duration-300 flex flex-col container cursor-pointer">
      <div className="relative">
        <img src={image} alt={name} className="w-full h-48 object-cover" />
        <div className="p-4 flex flex-col flex-grow">
          <h3
            className="text-lg font-semibold text-gray-800 mb-3 line-clamp-2"
            title={name}
          >
            {name}
          </h3>
          <h4 className="text-md font-semibold text-gray-800 line-clamp-2">
            R$ <span className="text-green-600">{price}</span>
          </h4>
          <div className="container">
            <p className="text-sm text-gray-800 mt-1">{description}</p>
          </div>
        </div>
      </div>
    </div>
  );
};
