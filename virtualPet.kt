class VirtualPet(val nome: String) {
    var nivelDeFome = 50
    var nivelFelicidade = 100
    var nivelCansaco = 0
    var idade = 0

    fun alimentar() {
        nivelDeFome -= 10
        println("$nome foi alimentado. O nível de fome diminuiu.")
    }

    fun brincar() {
        nivelFelicidade += 50
        nivelCansaco += 10
        println("$nome está brincando e se sentindo mais feliz.")
    }

    fun descansar(){
        nivelCansaco -= 50
        println("$nome está descansado")
    }
    fun verificarStatus() {
        println("Status atual de $nome:")
        println("Nível de fome: $nivelDeFome")
        println("Nível de felicidade: $nivelFelicidade")
    }

    fun passarTempo() {
        nivelDeFome += 3
        nivelFelicidade -= 3
        nivelCansaco += 10
        idade++
        println("$nome está ficando mais faminto com o passar do tempo.")
        println("O $nome está com $idade de idade")
        println("Nivel de fome: $nivelDeFome" +
                "\nNivel de felicidade: $nivelFelicidade" +
                "\nNivel de cansaço: $nivelCansaco")
    }
}

fun main() {
    println("Bem-vindo ao Simulador de Animal de Estimação Virtual!")
    println("Digite o nome do seu animal de estimação:")
    val nomePet = readLine() ?: "Baltazar Guilherme Tenório"
    val pet = VirtualPet(nomePet)

    while (true) {
        if (pet.nivelDeFome >= 100) {
            println("$nomePet está com fome extrema! Você perdeu.")
            break
        }
        if (pet.nivelCansaco >= 100) {
            println("$nomePet está exausto! Você perdeu.")
            break
        }

        println("\nEscolha uma ação:")
        println("1. Alimentar ${pet.nome}")
        println("2. Brincar com ${pet.nome}")
        println("3. Descansar o ${pet.nome}")
        println("4. Verificar o status do ${pet.nome}")
        println("5. Sair")

        val escolha = readLine()?.toIntOrNull() ?: continue

        when (escolha) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> pet.descansar()
            4 -> pet.verificarStatus()
            5 -> {
                println("Saindo do Simulador de Animal de Estimação Virtual. Adeus!")
                return
            }
            else -> println("Escolha inválida. Tente novamente.")
        }

        pet.passarTempo() // Simula a passagem do tempo após cada ação
    }
}
