interface ProductImageProps{
  enderecoImagem: string;
  textoAlternativo ?: string
}

export function ProductImage( {enderecoImagem, textoAlternativo} :  ProductImageProps ) {
  return (
      <img src={enderecoImagem} alt={textoAlternativo} />
  )
}