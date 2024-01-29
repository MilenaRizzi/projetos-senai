
interface ButtonProps {
    Icon?: React.ComponentType | undefined;
    title ?: string; // tornando 'type' opcional
    buttonProps?: React.DetailedHTMLProps<React.ButtonHTMLAttributes<HTMLButtonElement>, HTMLButtonElement>;

}

export function Button({ Icon, title, buttonProps }: ButtonProps) {
    return (
        <button {...buttonProps}>
            {Icon && <Icon />} {/* Renderiza o ícone se estiver definido. O tipo pode não ser definido, por isso a necessidade do if*/}
            {title}
        </button>
    )
}