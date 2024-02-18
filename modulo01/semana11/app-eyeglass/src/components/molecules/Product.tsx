import styles from "../organisms/ProductList.module.css";

interface ProducProps {
  nome: string;
  descricao: string;
  tipo: string;
  preco: string;
}

export function Product({ nome, descricao, tipo, preco }: ProducProps) {
  return (
    <div className={styles.product}>
      <div className={styles.nameAndDescription}>
        <p> {nome} </p>
        <p> {descricao} {tipo}</p>
      </div>
      <p>{preco}</p>
    </div>
  )
}