public void requestTicket(final String badge) {
    StringRequest ticketRequest = new StringRequest(
            Request.Method.GET,
            url.getTicketByBadgeURL(badge),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray arrayResponse = new JSONArray(response);
                        if(arrayResponse.length() == 0){
                            scanActivity.onInvalidTicket();
                            return;
                        }

                        JSONObject vehicleResponse = arrayResponse
                                .getJSONObject(0)
                                .getJSONObject("vehicle");
                        JSONObject parkingResponse = arrayResponse
                                .getJSONObject(0)
                                .getJSONObject("parking");

                        String plateCountry = vehicleResponse
                            .getString("plate_country");
                        String plateNumber = vehicleResponse
                            .getString("plate_number");
                        String parkingName = parkingResponse
                            .getString("name");

                        Ticket ticket = new Ticket(plateCountry, plateNumber, 
                            parkingName);
                        scanActivity.onValidTicket(ticket);

                    } catch (JSONException e) {
                        scanActivity.onParseError();
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if(error.networkResponse != null && 
                            error.networkResponse.statusCode == 406){
                        scanActivity.onInvalidTicket();
                        return;
                    }
                    scanActivity.onConnectionError();
                    error.printStackTrace();
                }
            }
    ) { };

    Volley.newRequestQueue(scanActivity).add(ticketRequest);
}
