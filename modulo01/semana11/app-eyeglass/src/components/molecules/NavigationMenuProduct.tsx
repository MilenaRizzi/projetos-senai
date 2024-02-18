import styles from './NagicationMenuProduct.module.css'


export function NavigationMenuProduct() {
  return (
    <div className={styles.navigationMenuProduct}> 
      <a href="#">Home</a>
      <span>/</span>
      <a href="#">Categories</a>
      <span>/</span>
      <a href="#">Komono</a>
      <span>/</span>
      <a href="#">The Lulu Matte Indigo Demi</a>
    </div>
  )
}