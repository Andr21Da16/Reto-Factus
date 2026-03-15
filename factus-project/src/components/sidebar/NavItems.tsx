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
    <nav className="flex flex-col w-full mt-5 flex-1 overflow-hidden bg-inherit">
      <div className="flex flex-col gap-2 overflow-y-auto pr-1">
        {navItems.map((g, index) => (
          <Fragment key={g.id}>
            <div className={`transition-all ${index !== 0 ? "mt-4" : ""}`}>
              <div className="flex items-center text-[13px] md:text-[14px] font-semibold tracking-widest text-gray-600 hover:text-gray-800">
                {g.label.toUpperCase()}
                <button
                  onClick={() => toggle(g.id)}
                  className="ml-auto p-1 rounded-full hover:bg-gray-200 transition-colors"
                >
                  <ChevronDown
                    size={18}
                    className={`transition-transform duration-300 ${
                      open[g.id] ? "rotate-180" : ""
                    }`}
                  />
                </button>
              </div>

              <div
                className={`
              grid transition-all duration-300 ease-out mt-2 ml-2
              ${open[g.id] ? "grid-rows-[1fr]" : "grid-rows-[0fr]"}
            `}
              >
                <div className="overflow-hidden">
                  <ul className="flex flex-col gap-1 max-h-40 md:max-h-48 overflow-y-auto pr-1">
                    {g.children?.map(item => (
                      <Item className={` gap-2 text-[14px] rounded-2xl pl-3 p-1.5 items-center`} key={item.id} item={item} />
                    ))}
                  </ul>
                </div>
              </div>
            </div>
            {g.id !== "options" && <SeparationBar />}
          </Fragment>
        ))}
      </div>
    </nav>

  )
}

export default NavItems;