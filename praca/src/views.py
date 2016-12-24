from django.shortcuts import render
from badges.models import Parking

def index(request):
    parking = Parking.objects.get()
    return render(request, 'badges/index.html', {'p_name': parking.name})
