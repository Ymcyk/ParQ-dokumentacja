@api_view(['POST'])
@permission_classes((IsAuthenticated,))
def payment_list(request):
    serializer = TransactionSerializer(data=request.data)
    if serializer.is_valid():
        try:
            driver = Driver.objects.get(pk=request.user.id)
        except Driver.DoesNotExist:
            return Response('User is not driver', 
                   status=status.HTTP_403_FORBIDDEN)

        money = get_payment_money(request.data['transaction_id'])
        serializer.save(user=request.user)
        driver.add_money(Decimal(money))
        driver.save()
        driver_ser = DriverSerializer(driver)
        return Response(driver_ser.data, status=status.HTTP_201_CREATED)
    return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
