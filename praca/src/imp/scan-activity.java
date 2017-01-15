StringRequest ticketRequest = new StringRequest(
        Request.Method.GET,
        url.getTicketByBadgeURL(badge),
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // w response znajduje się ciało odpowiedzi
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // w przypadku błędu. Kody 4xx i 5xx
                error.printStackTrace();
            }
        }
) { };

Volley.newRequestQueue(scanActivity).add(ticketRequest);
