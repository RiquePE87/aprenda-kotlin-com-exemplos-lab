enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, var formacoes: MutableList<Formacao> = mutableListOf<Formacao>())

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        usuario.formacoes.add(this)
        println("Usuário ${usuario.nome} matriculado com sucesso na formação $nome")
    }
}

fun main() {
    
    var usuario = Usuario(nome = "Henrique")
    val conteudo1 = ConteudoEducacional("Básico da Linguagem Kotlin")
    val conteudo2 = ConteudoEducacional("Orientação de objetos com Kotlin", duracao = 120)
    val conteudos = listOf(conteudo1, conteudo2)
    val formacao = Formacao(nome = "Desenvolviemto Kotlin", conteudos = conteudos, nivel = Nivel.INTERMEDIARIO);
    
    formacao.matricular(usuario)
    println(usuario)
}
