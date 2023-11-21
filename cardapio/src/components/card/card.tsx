import "./card.css"

interface CardProps {
    preco: number,
    titulo: string,
    imagem: string

}

export function Card({preco, titulo, imagem} : CardProps) {
    return (
        <div className="card">
            <img/>
            <h2></h2>
            <p><b>Valor:</b></p>
        </div>
    )
}