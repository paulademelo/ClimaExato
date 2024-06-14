# WeatherApp - Seu Companheiro para o Clima

Este aplicativo Android fornece informações meteorológicas atuais com base no nome da cidade ou na localização atual do usuário. Ele é construído usando práticas modernas de desenvolvimento Android, incluindo:

* **Jetpack Compose:** Para uma interface de usuário declarativa.
* **Kotlin Coroutines:** Para operações assíncronas eficientes.
* **Hilt:** Para injeção de dependência.
* **Retrofit:** Para rede e chamadas de API para OpenWeatherMap.
* **Fused Location Provider:** Para obtenção de localização precisa e eficiente em termos de bateria.

## Funcionalidades

* **Pesquisa por Cidade:** Digite o nome de uma cidade para obter as condições meteorológicas atuais.
* **Clima Baseado em Localização:** Busca automaticamente o clima para a localização atual do usuário (requer permissões de localização).
* **Interface Limpa:** Exibe a temperatura e as condições meteorológicas com uma cor de fundo que reflete o clima.
* **Tratamento de Erros:** Fornece mensagens informativas em caso de problemas de rede ou dados inválidos.

## Estrutura do Projeto

* **`presentation`:** Contém os componentes da interface do usuário construídos com Jetpack Compose.
    * `MainScreen`: A tela principal do aplicativo.
* **`viewmodels`:** Contém o `WeatherViewModel` que gerencia o estado da interface do usuário e a busca de dados.
* **`data`:** Contém a camada de dados.
    * `api`: Define a interface `OpenWeatherMapService` para interagir com a API OpenWeatherMap.
    * `repositories`: Inclui o `WeatherRepository` que lida com a busca de dados e fornece uma API limpa para o ViewModel.
* **`di`:** Define os módulos Hilt para injeção de dependência.

## Começando

1. **Clone o repositório:** `git clone https://github.com/paulademelo/WeatherApp.git`
2. **Obtenha uma Chave de API:** Obtenha uma chave de API gratuita em [OpenWeatherMap](https://openweathermap.org/api).
3. **Adicione a Chave de API:** Substitua `YOUR_API_KEY` no `NetworkModule` pela sua chave de API real.
4. **Construa e Execute:** Abra o projeto no Android Studio e construa o aplicativo.

## Melhorias Futuras

* **Dados Meteorológicos Mais Detalhados:** Exibir informações adicionais como umidade, velocidade do vento e previsão.
* **Interface Personalizável:** Permitir que os usuários personalizem a aparência do aplicativo.
* **Suporte Offline:** Armazenar em cache os dados meteorológicos para acesso offline.

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.
