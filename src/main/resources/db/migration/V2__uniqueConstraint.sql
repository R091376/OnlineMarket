ALTER TABLE "user-m" ADD CONSTRAINT username_in_user_unique_constr UNIQUE (username);
ALTER TABLE "product-m" ADD CONSTRAINT name_in_product_unique_constr UNIQUE (name);