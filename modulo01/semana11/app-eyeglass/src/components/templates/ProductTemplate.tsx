import { Update } from "../molecules/Updated";
import { Footer } from "../organisms/Footer";
import { Header } from "../organisms/Header";
import { ProductInfo } from "../organisms/ProductInfo";
import { ProductList } from "../organisms/ProductList";

export function ProductTemplate() {
  return (
    <div>
      <Header />
      <ProductInfo />
      <ProductList />
      <Update />
      <Footer/>
    </div>
  );
}
