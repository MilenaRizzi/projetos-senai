import { Page } from "./components/Page"
import { ThemeProvider } from "./contexts/ThemeContext"

function App() {
  return (
    <div>
      <ThemeProvider>
        <Page/>
      </ThemeProvider>
    </div>
  )
}

export default App
