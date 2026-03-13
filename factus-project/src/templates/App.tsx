
import Sidebar from "#/sidebar/Sidebar.tsx";
import { Outlet} from "react-router";
import Header from "#/header/Header.tsx";





function App() {




  return (
    <div className="h-screen overflow-hidden p-3 w-full bg-white grid md:grid-cols-[minmax(220px,260px)_1fr] md:grid-rows-[40px_1fr]">

      <Sidebar className="row-span-2 w-full" />

      <Header className=" flex items-center px-6" />

      <main className="bg-gray-200 rounded-2xl p-8 overflow-y-auto">
        <Outlet />
      </main>

    </div>


  )
}

export default App
