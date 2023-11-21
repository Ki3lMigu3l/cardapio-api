import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import { Card } from './components/card/card';
import { FoodData } from './interface/FoodData';

function App() {
  const data: FoodData[] = [];

  return (
    <div className="App">
        <h1>Cardápio</h1>
        <div className="card-grid">
          {data.map(foodData => 
            <Card 
              preco={foodData.preco} 
              titulo={foodData.nome} 
              imagem={foodData.imagem}
            />
          )}
        </div>
    </div>
  )
}

export default App
