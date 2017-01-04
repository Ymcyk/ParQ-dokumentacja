public class ParQURLConstructor {
    private String authority;
    private Context context;

    public ParQURLConstructor(String authority, Context context) {
        this.authority = authority;
        this.context = context;
    }

    private Builder getBase() {
        return new Builder()
                .scheme("http")
                .encodedAuthority(authority);
    }

    public String getTicketByBadgeURL(String badge) {
        Builder builder = getBase()
                .appendEncodedPath(context.getString(R.string.url_tickets))
                .appendQueryParameter("badge", badge);
        return builder.build().toString();
    }
}
