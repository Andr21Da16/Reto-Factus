import { useState } from 'react'
import { useAuth } from "@/context/AuthContext.tsx";
import { useQuery } from "@tanstack/react-query";
import api from "@/api/axios.ts";


const fetchCompany = async () =>{
  const data = await api.get(`/companies/1`);
  console.log(data);
  return data.data;
}

function App() {

  const {logout} = useAuth()

  const [count, setCount] = useState(0)
  const { data, isLoading} = useQuery({
    queryKey: ['companies'], // Identificador único de la query
    queryFn: fetchCompany,
  });
  if (isLoading) {
    return <div>Loading...</div>;
  }
   return (
    <>

      <h1>Vite + React</h1>
      <div className="card">
        <div>
          <h1 className="text-2xl">{data?.data.nameCompany}</h1>
        </div>
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
