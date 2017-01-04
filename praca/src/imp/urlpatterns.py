urlpatterns = [
    url(r'^login/', ParQAuthToken.as_view()),
    url(r'^register/$', register_driver),
    url(r'^vehicles/$', vehicle_list),
    url(r'^vehicles/(?P<pk>[0-9]+)$', vehicle_detail),
    url(r'^parkings/$', parking_list),
    url(r'^tickets/$', ticket_list),
    url(r'^current/$', current_user),
    url(r'^payments/$', payment_list),
]
