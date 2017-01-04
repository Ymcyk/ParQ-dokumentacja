public void postVehicle(Vehicle vehicle) {

    Map<String, String> params = new HashMap<>();
    params.put("name", vehicle.getName());
    params.put("plate_country", vehicle.getPlateCountry());
    params.put("plate_number", vehicle.getPlateNumber());

    JsonObjectRequest addVehiclePost = new JsonObjectRequest(
                Request.Method.POST, App.getUrl().getVehiclesURL(),
            new JSONObject(params),
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.i("AddVehicle", "Response success");
                    addVehicleActivity.addVehiclePostSuccess();
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    if(error.networkResponse != null){
                        if(error.networkResponse.statusCode == 401) {
                            addVehicleActivity.connectionError(
                            App.UNAUTHENTICATED);
                            Log.d("addVehicle", "Bad token 401");
                        } else if(error.networkResponse.statusCode == 403) {
                            addVehicleActivity.connectionError(
                            App.UNAUTHENTICATED);
                            Log.d("addVehicle", "Bad role 403");
                        }
                    }

                    error.printStackTrace();
                    Log.d("VehicleList", "Connection error");
                    addVehicleActivity.connectionError(App.CONNECTION_ERROR);
                }
            }
    ) {
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> headers = new HashMap<>();
            headers.put("Authorization", String.format("Token %s", 
                LoginAPI.getToken()));
            return headers;
        }

    };
    Volley.newRequestQueue(addVehicleActivity).add(addVehiclePost);
}
