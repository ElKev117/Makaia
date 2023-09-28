import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		// Creamos una pila para almacenar los tags de apertura que aún no se han cerrado
		Stack<HtmlTag> openTags = new Stack<>();

		// Recorremos la cola de tags
		while (!tags.isEmpty()) {
			// Obtenemos el siguiente tag de la cola
			HtmlTag currentTag = tags.poll();

			// Verificamos si el tag actual es un tag de apertura
			if (currentTag.isOpenTag()) {
				//lo agregamos a la pila
				if (!currentTag.isSelfClosing()) {
					openTags.push(currentTag);
				}
			} else {
				// Si el tag es uno de cierre y la pila está vacía, devolvemos null
				if (openTags.isEmpty() && !currentTag.isSelfClosing()) {
					return null;
				}

				// Si el tag no es autocerrante, verificamos si coincide con el último tag de apertura en la pila
				if (!currentTag.isSelfClosing()) {
					HtmlTag lastOpenedTag = openTags.peek();

					// Si los tags coinciden, quitamos el tag de apertura de la pila
					if (currentTag.matches(lastOpenedTag)) {
						openTags.pop();
					} else {
						// Si no , devolvemos la pila tal como está
						return openTags;
					}
				}
			}
		}

		// Si quedan tags de apertura en la pila, los devolvemos
		if (!openTags.isEmpty()) {
			return openTags;
		}

		// Si no quedan tags de apertura en la pila, devolvemos una pila vacía
		return new Stack<>();
	}
	

}

