package common;

public class BaseConfiguration {

    // add any common global variables here
    public static String restServiceExampleUrl = "https://jsonplaceholder.typicode.com";
    public static String graphqlServiceExampleUrl = "https://beta.pokeapi.co/graphql/v1beta";

    // GraphQL Queries
    public static String getTypesQuery = "query getTypes($limit: Int) {pokemon_v2_type(limit: $limit) { id generation_id name }}";
}
