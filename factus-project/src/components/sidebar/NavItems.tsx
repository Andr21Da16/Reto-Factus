import { Fragment, useState } from "react";
import { navItems } from "@/util/constants.ts";
import { ChevronDown } from "lucide-react";
import Item from "#/sidebar/Item.tsx";
import SeparationBar from "#/common/SeparationBar.tsx";




const NavItems = () => {
  const [open, setOpen] = useState<Record<string, boolean>>(
    Object.fromEntries(navItems.map(g => [g.id, true]))
  );



  const toggle = (id: string) => {
    setOpen((prev) => ({
      ...prev,
      [id]: !prev[id],
    }));
  };

  return (
    <nav className="flex flex-col w-full mt-5 max-h-96 min-h-fit bg-inherit">

      {navItems.map((g, index) => (

        <Fragment key={g.id}>

          <div className={`transition-all ${index !== 0 ? "mt-5" : ""}`}>

            {/* HEADER DEL GRUPO */}
            <div className="flex items-center text-[14px] font-semibold tracking-widest hover:text-gray-800">

              {g.label.toUpperCase()}

              <button
                onClick={() => toggle(g.id)}
                className="ml-auto p-1 hover:bg-gray-300 rounded-full transition-colors"
              >
                <ChevronDown
                  size={18}
                  className={`transition-transform duration-300 ${
                    open[g.id] ? "rotate-180" : ""
                  }`}
                />
              </button>

            </div>

            {/* CONTENEDOR ANIMADO */}
            <div
              className={`
                grid transition-all duration-300 ease-out mt-1.5 ml-2
                ${open[g.id] ? "grid-rows-[1fr]" : "grid-rows-[0fr]"}
              `}
            >

              <div className="overflow-hidden">

                <ul className="max-h-[145px] overflow-y-auto pr-1 flex flex-col gap-1">

                  {g.children?.map(item => (
                    <Item key={item.id} item={item}/>
                  ))}

                </ul>
              </div>
            </div>

          </div>

          {g.id !== "options" && <SeparationBar/>}

        </Fragment>

      ))}

    </nav>
  )
}

export default NavItems;