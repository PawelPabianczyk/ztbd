import random
import codecs
import datetime


def random_from_file(filename, n):
    values = []
    random_values = []
    with codecs.open(filename, 'r', encoding='utf8') as f:
        values = f.read().splitlines()
        while len(random_values) < n:
            random_value = values[
                random.randint(0, len(values) - 1)]
            random_values.append(random_value)
    return random_values


def random_first_names(n):
    return random_from_file('raw_data/first_names.txt', n)


def random_last_names(n):
    return random_from_file('raw_data/last_names.txt', n)


def random_city(n):
    return random_from_file('raw_data/cities.txt', n)


def random_streets(n):
    return random_from_file('raw_data/streets.txt', n)


def random_regions(n):
    return random_from_file('raw_data/regions.txt', n)


def random_phone_number():
    return "+48" + str(random.randrange(100000000, 999999999))


def random_nip():
    return str(random.randrange(1000000000, 9999999999))


def random_house_number():
    return str(random.randrange(0, 1000))


def random_flat_number():
    no_number = random.randrange(0, 2)
    if no_number == 1:
        return ""
    else:
        return str(random.randrange(0, 100))


def random_postcode():
    a = str(random.randrange(10, 100))
    b = str(random.randrange(100, 1000))
    return a + "-" + b


first_date = datetime.date.fromisoformat('2021-01-01')
last_date = datetime.date.fromisoformat('2021-10-31')


def random_date_between(start, end):
    return start + datetime.timedelta(
        seconds=random.randint(0, int((end - start).total_seconds())),
    )


def random_date_after(start):
    return random_date_between(start, last_date)


def random_date_before(end):
    return random_date_between(first_date, end)


def random_date():
    return random_date_between(first_date, last_date)
