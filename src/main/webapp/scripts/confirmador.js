/**
 * Confirmação da exclusão de um contato
 */

function confirmarExclusao(idcon) {
	const resposta = confirm("Confirme a exclusão deste contato");
	if(resposta) {
		window.location.href = "delete?idcon=" + idcon;
	}
}