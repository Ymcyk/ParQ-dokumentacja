def calculate_price(self, ticket):
    effective_dates = self._get_effective_dates(ticket)
    time = self._to_minutes(effective_dates[1] - effective_dates[0])
    charges = list(self.charges.all().order_by('-schedulecharge__order'))

    if not charges:
        raise Exception('Schedule without charges')

    price = Decimal()
    while time > 0:
        charge = charges.pop()
        if len(charges) == 0 or time <= charge.duration:
            price += charge.calculate_price(time)
            break
        else:
            price += charge.calculate_price(charge.duration)
            time -= charge.duration
    return price
