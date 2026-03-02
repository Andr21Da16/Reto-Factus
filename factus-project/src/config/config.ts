import { QueryClient } from "@tanstack/react-query";

export const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      retry: 1,             // reintenta 1 vez si falla
      refetchOnWindowFocus: false, // no refetchea al volver a la pestaña
    },
  },
});