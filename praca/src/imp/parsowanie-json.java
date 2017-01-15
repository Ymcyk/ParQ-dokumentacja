JSONArray array = new JSONArray(response);

LinkedList<Vehicle> vehicleList = new LinkedList<>();

for(int i = 0; i < array.length(); i++) {
    JSONObject json = array.getJSONObject(i);
    Vehicle vehicle = new Vehicle();

    vehicle.setId(json.getInt("id"));
    vehicle.setBadge(json.getString("badge"));
    vehicle.setName(json.getString("name"));
    vehicle.setPlateCountry(json.getString("plate_country"));
    vehicle.setPlateNumber(json.getString("plate_number"));

    vehicleList.add(vehicle);
}
