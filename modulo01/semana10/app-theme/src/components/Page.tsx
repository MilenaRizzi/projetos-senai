import { useTheme } from "../contexts/ThemeContext";
import { Header } from "./Header";
import { Button } from "../components/Button"

export function Page() {

    const { theme } = useTheme();

    return (
        <div style={{
            height: "100vh",
            background: theme === "light" ? "#fff" : "#333",
            color: theme === "light" ? "#333" : "#fff",
        }}>
            <Header />
            <Button />

            <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Aperiam asperiores velit ut, cupiditate ducimus nemo rerum eaque facilis incidunt natus officiis quos ab quod non necessitatibus doloremque, eos iure. Voluptatibus.
            </p>
            <h4>Lorem ipsum dolor sit amet consectetur adipisicing elit.</h4>
        </div>
    )
}

