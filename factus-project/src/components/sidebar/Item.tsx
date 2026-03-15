
import { NavLink, useNavigate } from "react-router";
import type { NavItem } from "@/types";
import { useAuth } from "@/context/AuthContext.tsx";


type ItemProps = {
  item: NavItem
  className: string
}

const Item = ({ item, className }: ItemProps) => {

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
          className={`flex ${className} hover:bg-gray-200 w-full cursor-pointer`}
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
          ` flex ${className}
          ${isActive ? "bg-black text-white" : "text-black hover:bg-gray-200"}`
        }
      >
        {content}
      </NavLink>
    </li>
  );
};
export default Item