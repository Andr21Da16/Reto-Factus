const Login = () => {


    const cards = [
        {
            title: "Análisis en tiempo real",
            description: "Visualiza tus métricas de negocio al instante"
        },
        {
            title: "Gestión de Equipos",
            description: "Colabora con tu equipo de forma eficiente",
        },
        {
            title: "Control de Inventario",
            description: "Mantén tu stock siempre actualizado"
        },
        {
            title: "Seguridad Avanzada",
            description: "Protección de datos de nivel empresarial"
        }
    ]
    return (
        <div className="w-full min-h-screen flex justify-center items-center">
            <div className="flex">



                
                <div className="bg-red-600">
                    <div>
                        <h1>Factus Project</h1>
                        <span>Reto Factus HallTech</span>
                    </div>
                    <h2>Sistema de gestión empleando la API de Factus</h2>
                    <div className="grid grid-cols-2">
                        { 
                            cards.map(card => (
                                <div className="flex flex-col">
                                    <span>{card.title}</span>
                                    <span>{card.description}</span>
                                </div>
                            ))
                        }
                    </div>

                </div>
                <div>
                    <form >
                        <input type="text" name="" id="" />
                    </form>
                </div>
            </div>
            
        </div>
    )
}

export default Login;