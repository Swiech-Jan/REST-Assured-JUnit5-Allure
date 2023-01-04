public class GraphQLQuery {
    private String query;
    private Object variables;

    public void setQuery(String query){
        this.query = query;
    }

    public String getQuery() {
        return this.query;
    }

    public void setVariables(Object variables){
        this.variables = variables;
    }

    public Object getVariables(){
        return this.variables;
    }

}
