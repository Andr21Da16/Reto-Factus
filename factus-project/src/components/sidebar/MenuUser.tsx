
import { Link } from "react-router";
import type { User } from "@/@types/Auth.type.ts";
import { Settings } from "lucide-react";
import SeparationBar from "#/common/SeparationBar.tsx";
import { MenuUserItems } from "@/util/constants.ts";
import Item from "#/sidebar/Item.tsx";



interface MenuProps {
  open: boolean;
  user: User;
}


const MenuUser = ({ open, user } : MenuProps) =>{




  return (

    <div
      className={`
        flex flex-col absolute right-[50%] bottom-13 w-55
        bg-white rounded-xl shadow-xl border border-gray-300
        p-3
        transform origin-bottom-right overflow-hidden
        transition duration-500 ease-out
        ${open
            ? "opacity-100 scale-100 translate-y-0"
            : "opacity-0 scale-95 -translate-y-1 pointer-events-none"}
      `}

    >
      <div className={`flex items-center relative gap-3 w-full h-fit`}>
        <div className={`flex flex-col justify-center gap-1`}>
          <span className={`font-bold truncate `}>{user.firstName}</span>
          <span className={`truncate text-xs italic`}> {user.role}</span>
        </div>
        <Link to={`/config/user`} className={`flex items-center justify-center ml-auto p-1  h-fit hover:bg-gray-200 rounded-full`}><Settings size={18}/></Link>
      </div>
      <SeparationBar/>
      <div className={`flex flex-col mt-2 gap-1`}>
        {
          MenuUserItems.map((item) => (
            <Item
              className={"text-[12px] gap-2 items-center rounded-md p-1 pl-0.5 after:"}
              key={item.id}
              item={item} />
          ))
        }
      </div>

    </div>

  );
}

export default MenuUser;