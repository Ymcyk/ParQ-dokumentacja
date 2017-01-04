from decimal import Decimal
from django.db import models
from django.contrib.auth.models import User
from djroles.models import Role
from djroles.roles import BaseRole

class Driver(models.Model, BaseRole):
    user = models.OneToOneField(
            User, 
            on_delete=models.CASCADE,
            primary_key=True
            )
    wallet = models.DecimalField(
            _('wallet'),
            max_digits=8,
            decimal_places=2,
            default=Decimal()
            )
