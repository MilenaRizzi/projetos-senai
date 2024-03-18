import { UserList } from "./components/UserList";
import styles from "./App.module.css";

function App() {
  return (
    <div className={styles.wrapper}>
      <UserList />
    </div>
  );
}

export default App;
