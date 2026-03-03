import ProtectedRoute from "#/common/ProtectedRoute.tsx";

import { createBrowserRouter } from "react-router";

import { lazy, Suspense } from "react";
import Loader from "#/common/Loader.tsx";

const App = lazy(() => import("@/templates/App"));
const Login = lazy(() => import("@/templates/Login"));

export const router = createBrowserRouter([
  {
    path: "/",
    element: (
      <ProtectedRoute>
        <Suspense fallback={<Loader/>}>
          <App />
        </Suspense>
      </ProtectedRoute>
    ),
  },
  {
    path: "/login",
    element: (
      <Suspense fallback={<Loader/>}>
        <Login />
      </Suspense>),
  },
]);