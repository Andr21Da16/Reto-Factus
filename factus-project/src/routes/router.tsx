import ProtectedRoute from "#/ProtectedRoute";
import App from "@/templates/App";
import Login from "@/templates/Login";
import { createBrowserRouter } from "react-router";

export const router = createBrowserRouter([
  {
    path: "/",
    element: (
      <ProtectedRoute>
        <App />
      </ProtectedRoute>
    ),
  },
  {
    path: "/login",
    element: <Login />,
  },
]);