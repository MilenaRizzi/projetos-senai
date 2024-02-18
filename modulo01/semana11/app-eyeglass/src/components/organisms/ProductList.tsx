import { Button } from "../atoms/Button";
import { MenuItem } from "../atoms/MenuItem";
import { Product } from "../molecules/Product";

import styles from './ProductList.module.css'

export function ProductList() {
  return (
    <div className={styles.content}>
      <div className={styles.menuProduct}>
        <MenuItem title="More from Komono" />
        <MenuItem title="Recommendations" />
        <MenuItem title="Wear It With" />
      </div>

      <div className={styles.productList}>
        <div className={styles.productComponent}>
          <img src="src\assets\2.png" alt="" />
          <Product
            nome="Komono"
            descricao="The Lulu / "
            tipo="Black"
            preco="£ 79,95" />
        </div>
        <div className={styles.productComponent}>
          <img src="src\assets\3.png" alt="" />
          <Product
            nome="Komono"
            descricao="The Lulu / "
            tipo="Black"
            preco="£ 79,95" />
        </div>
        <div className={styles.productComponent}>
          <img src="src\assets\4.png" alt="" />
          <Product
            nome="Komono"
            descricao="The Lulu / "
            tipo="Black"
            preco="£ 79,95" />
        </div>
        <div className={styles.productComponent}>
          <img src="src\assets\5.png" alt="" />
          <Product
            nome="Komono"
            descricao="The Lulu / "
            tipo="Black"
            preco="£ 79,95" />
        </div>
        <div className={styles.productComponent}>
          <img src="src\assets\6.png" alt="" />
          <Product
            nome="Komono"
            descricao="The Lulu / "
            tipo="Black"
            preco="£ 79,95" />
        </div>
        <div className={styles.productComponent}>
          <img src="src\assets\7.png" alt="" />
          <Product
            nome="Komono"
            descricao="The Lulu / "
            tipo="Black"
            preco="£ 79,95" />
        </div>
      </div>
      <div className={styles.button}>
        <Button text="Show more" />

      </div>

    </div>
  )
}