
import Sidebar from "#/sidebar/Sidebar.tsx";
import { Outlet, useNavigate } from "react-router";
import { useAuth } from "@/context/AuthContext.tsx";
import Header from "#/header/Header.tsx";



function App() {




  return (
    <div className="min-h-screen p-3 w-full bg-white grid md:grid-cols-[minmax(220px,320px)_1fr] md:grid-rows-[75px_1fr]">

      <Sidebar className="row-span-2 w-full" />

      <Header className="flex items-center px-6" />

      <main className="bg-gray-800 rounded-xl p-8 overflow-y-auto">
        <Outlet />
      </main>

    </div>


  )
}

export default App
