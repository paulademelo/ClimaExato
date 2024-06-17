# 🌤️ Clima Exato - Seu Companheiro para o Clima
Este é um aplicativo simples de previsão do tempo para Android, desenvolvido em Kotlin.

## Descrição

O Clima Exato permite aos usuários verificar a previsão do tempo de diferentes cidades usando a API do OpenWeatherMap.

## Tecnologias Utilizadas

- Kotlin
- Jetpack Compose
- Dagger Hilt para injeção de dependência
- Retrofit para comunicação com API REST
- Coroutines para programação assíncrona

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- **`app`**: Contém a lógica principal do aplicativo, incluindo atividades, fragmentos, viewmodels e componentes UI.
- **`data`**: Classes e interfaces relacionadas à camada de dados, como modelos, repositórios e serviços de API.
- **`di`**: Módulos Dagger Hilt para injeção de dependência.
- **`presentation`**: Componentes de UI Compose e viewmodels associados.
- **`ui`**: Recursos de interface do usuário, como widgets personalizados, estilos e recursos de layout.

## Como Usar

Para compilar e executar o projeto localmente, siga estas etapas:

1. Clone este repositório.
2. Abra o projeto no Android Studio.
3. Sincronize as dependências do Gradle.
4. Compile e execute o aplicativo em um dispositivo ou emulador Android.

Certifique-se de configurar sua chave de API do OpenWeatherMap no arquivo `gradle.properties`.

## Uso de Coroutines

Coroutines são utilizadas no projeto para realizar operações assíncronas, como chamadas de rede para obter dados meteorológicos. Aqui estão alguns exemplos de onde as coroutines são usadas:

- **ViewModel**: Operações assíncronas no ViewModel para buscar dados do clima.
- **Repository**: Chamadas assíncronas para a API do OpenWeatherMap usando Retrofit.

## Contribuições

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver alguma sugestão, sinta-se à vontade para abrir uma issue.

## Autor
Paula de Melo
