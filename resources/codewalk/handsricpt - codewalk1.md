- Hello we are team E, my name is Xujia. My teammates are Naihai and Jason.

- As for the assignment, we have basically developed the backend for a property company, with our primary emphasis on incorporating essential entities like properties, contracts (sales and rentals), listings, and real estate agents.

- We have outlined a set of 10 classes for this purpose.  "contracts" and "properties" are abstract classes,  rental and sales are concrete classes inheritatd from contracts while residental and commercial are concrete classes inheritatd from contracts. "agents" and "listings" are integrated with the abstract "contracts" and "properties" respectively to advance the generic design and implementation.

  

- The `Contract` class defines common attributes for contracts, such as asking price and negotiability, and it also provides methods for validation and calculation.

  - for the constructors, we initializes the `askingPrice` and `isNegotiable` attributes of a contract object with the provided values. but if the asking price is negative, it will throws an `InvalidArgumentException` becuase we wanna ensure that contracts are instantiated with valid parameters.



- The `Rental` class extends `Contract` and adds a term attribute representing the duration of the rental contract in months, along with methods for validation and calculation specific to rental contracts.
  - calculateBaseCommissionEarnings(): This overridden method calculates the base commission earnings  by multiplying the asking price of the rental contract with its term. It extends the behavior of the base class contract class method to incorporate the rental term into the commission calculation.

- Similarly for, The `Sale` class also extends `Contract`, inheriting common attributes and behaviors from `Contract` but it does not provide addintional attribute compared with the rental class

  - Rental` and `Sale` classes inherit attributes such as `askingPrice` and `isNegotiable` alongand methods like `calculateBaseCommissionEarnings()`, `equals()`, `hashCode()`, and `toString()` from the `Contract` class.
  - We employed a bottom-up testing approach to test the subclasses, thereby ensuringthe entire coverage of the parent class as well.

  



