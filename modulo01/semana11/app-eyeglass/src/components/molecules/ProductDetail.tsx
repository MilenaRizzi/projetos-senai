import { Button } from "../atoms/Button";
import styles from './ProductDetail.module.css'

export function ProductDetail() {
  return (
    <div className={styles.productDetail}>
      <h1>Komono</h1>
      <p>The Lulu / Matte Indigo Demi</p>
      <p>£ 119,95</p>
      <div className={styles.button}>
        <Button text="Add to Bag" />
      </div>
    </div>
  )
}