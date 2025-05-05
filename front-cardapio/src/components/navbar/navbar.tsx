import { useEffect, useState } from "react";
import { FiUser } from "react-icons/fi";
import { Link } from "react-router-dom";

export const Navbar = () => {
  const [isScrolled, setIsScrolled] = useState(false);

  useEffect(() => {
    const handleScroll = () => {
      setIsScrolled(window.scrollY > 5);
    };

    window.addEventListener("scroll", handleScroll);
    return () => window.removeEventListener("scroll", handleScroll);
  }, []);

  return (
    <nav
      className={`fixed w-full z-50 transition-all duration-500 ${
        isScrolled ? "bg-white shadow-sm py-5" : "bg-white py-4"
      } border-b border-gray-100`}
    >
      <div className="flex justify-between max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex-shrink-0 flex items-center">
          <Link
            to="/"
            className="text-xl font-medium text-gray-800 hover:text-yellow-500 cursor-pointer"
          >
            Cardápio API
          </Link>
        </div>
        <div className="flex items-center space-x-1">
          <Link
            to="/admin"
            className="p-2 rounded-full text-gray-700 hover:text-amber-600 hover:bg-amber-50 relative transition-colors cursor-pointer"
          >
            <FiUser className="h-5 w-5" />
          </Link>
        </div>
      </div>
    </nav>
  );
};
