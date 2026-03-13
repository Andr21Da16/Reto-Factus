
import { NavLink, useNavigate } from "react-router";
import type { NavItem } from "@/types";
import { useAuth } from "@/context/AuthContext.tsx";


type ItemProps = {
  item: NavItem
}

const Item = ({ item }: ItemProps) => {

  const IconComponent = item.icon;
  const { logout } = useAuth();
  const navigate = useNavigate();

  const handleClick = () => {
    if (item.action === "logout") {
      logout();
      navigate("/login");
    }
  };

  const content = (
    <>
      {IconComponent && <IconComponent />}
      <span>{item.label}</span>
    </>
  );

  if (item.action) {
    return (
      <li>
        <button
          onClick={handleClick}
          className="flex gap-2 text-[14px] rounded-2xl pl-3 p-1.5 items-center hover:bg-gray-200 w-full cursor-pointer"
        >
          {content}
        </button>
      </li>
    );
  }

  return (
    <li>
      <NavLink
        to={item.path ?? ""}
        className={({ isActive }) =>
          `flex gap-2 text-[14px] rounded-2xl pl-3 p-1.5 items-center
          ${isActive ? "bg-black text-white" : "text-black hover:bg-gray-200"}`
        }
      >
        {content}
      </NavLink>
    </li>
  );
};
export default Item