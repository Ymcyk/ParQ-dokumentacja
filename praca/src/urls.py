urlpatterns = [
    url(r'index/^$', views.index, name='index'),
    url(r'^admin/', admin.site.urls),
]
