import ProtectedRoute from "#/common/ProtectedRoute.tsx";

import { createBrowserRouter, Navigate } from "react-router";

import { lazy, Suspense } from "react";
import Loader from "#/common/Loader.tsx";

const App = lazy(() => import("@/templates/App"));
const Login = lazy(() => import("@/templates/Login"));
const Dashboard = lazy(() => import("#/pages/Dashboard"));

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
    children: [
      {
        index: true,
        element: <Navigate to="dashboard" replace />
      },
      {
        index: true,
        path: "dashboard",
        element: (
          <Suspense fallback={<Loader />}>
            <Dashboard />
          </Suspense>
        ),
        handle: {
          screenTitle: "Dashboard",
        },
      },
      {}
    ]
  },
  {
    path: "/login",
    element: (
      <Suspense fallback={<Loader/>}>
        <Login />
      </Suspense>),
  },
]);