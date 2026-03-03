import { useState } from 'react'
import { useAuth } from "@/context/AuthContext.tsx";



function App() {

  const {logout} = useAuth()
  const [count, setCount] = useState(0)

  return (
    <>
      <div>
       
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button className="bg-amber-300 text-6xl" onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>

      <button type="button" onClick={() => logout()} className="bg-amber-300 text-6xl rounded-md">
        log out
      </button>
    </>
  )
}

export default App
