import styles from "../molecules/ProductDetail.module.css";

export function DetailsProduct() {
  return (
    <div className={styles.detail}>
      <details>
          <summary className={styles.summaryDetails}>Details +</summary>
          <p>Descrição do produto, informações adicionais, etc.</p>
        </details>
    </div>
  )
}